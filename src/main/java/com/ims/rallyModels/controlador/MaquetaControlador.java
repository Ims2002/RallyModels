package com.ims.rallyModels.controlador;

import com.ims.rallyModels.modelo.CompraEntity;
import com.ims.rallyModels.modelo.MaquetaEntity;
import com.ims.rallyModels.modelo.UserModel;
import com.ims.rallyModels.reportes.FacturaExporterExcel;
import com.ims.rallyModels.reportes.FacturaExporterPDF;
import com.ims.rallyModels.servicio.coche.ICocheServicio;
import com.ims.rallyModels.servicio.competicion.ICompeticionService;
import com.ims.rallyModels.servicio.compra.ICompraServicio;
import com.ims.rallyModels.servicio.img.StorageService;
import com.ims.rallyModels.servicio.maqueta.IMaquetasServicio;
import com.ims.rallyModels.servicio.userMng.IUsuarioServicio;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/public")
public class MaquetaControlador {
  /*
    @GetMapping({"/","maquetas"})
    public String index(){
        return "public/maqueta";
    }


    HTTP GET /users – returns all the users in the system.
    HTTP GET /users/{id} – returns a user by specified id.
    HTTP POST /users – creates a new user in the system.

    @ para path
    $ para objetos
    ? para mensajes
    ~ para href/frg

    */

    @Autowired
    private IMaquetasServicio maquetasServicio;

    @Autowired
    private ICocheServicio cocheServicio;

    @Autowired
    private ICompeticionService competicionService;

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @Autowired
    private ICompraServicio compraServicio;

    @Autowired
    private StorageService storageService;

    @Autowired
    private HttpSession session;

    private UserModel usuario;

    private List<MaquetaEntity> maquetas;

    /*
    @GetMapping({"/index","/","/maquetas",""})//url path
    public String listarMaquetas(Model model) {
        return "index";//html path
    }*/

    @ModelAttribute("carrito")
    public List<MaquetaEntity> productosCarrito() {
        List<Integer> contenido = (List<Integer>) session.getAttribute("carrito");
        return (contenido == null) ? null : maquetasServicio.variosPorId(contenido);
    }

    @ModelAttribute("total_carrito")
    public Double totalCarrito() {
        List<MaquetaEntity> productosCarrito = productosCarrito();
        if (productosCarrito != null) {
            return productosCarrito.stream()
                    .mapToDouble(p -> p.getPrecio())
                    .sum();
        }
        return 0.0;
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model) {
        return "public/carrito";
    }

    @GetMapping("/carrito/add/{id}")
    public String addCarrito(Model model, @PathVariable Integer id) {
        List<Integer> contenido = (List<Integer>) session.getAttribute("carrito");
        if (contenido == null)
            contenido = new ArrayList<>();
        if (!contenido.contains(id))
            contenido.add(id);
        session.setAttribute("carrito",contenido);
        return "redirect:/public/carrito";
    }

    @GetMapping("/carrito/eliminar/{id}")
    public String borrarDelCarrito(Model model, @PathVariable Integer id) {
        List<Integer> contenido = (List<Integer>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/maquetas";
        contenido.remove(id);
        if (contenido.isEmpty())
            session.removeAttribute("carrito");
        else
            session.setAttribute("carrito",contenido);
        return "redirect:/public/carrito";
    }

    @GetMapping("/carrito/finalizar")
    public String finalizarCompra() {
        List<Integer> contenido = (List<Integer>) session.getAttribute("carrito");
        if (contenido == null)
            return "redirect:/maquetas";
        List<MaquetaEntity> productos = productosCarrito();
        CompraEntity c = compraServicio.insertar(new CompraEntity(),usuario);
        productos.forEach(p -> compraServicio.addMaquetaCompra(p,c));
        session.removeAttribute("carrito");
        return "redirect:/public/compra/factura/"+c.getIdCompra();
    }

    @GetMapping("/miscompras")
    public String verMisCompras(Model model) {
        return "/compra/listado";
    }

    @GetMapping("/compra/factura/{id}")
    public String factura(Model model, @PathVariable Integer id, HttpServletResponse response) throws IOException {
        /*response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Compra_"+fechaActual+".pdf";

        response.setHeader(cabecera,valor);*/

        CompraEntity c = compraServicio.obtenerCompraPorId(id);
        List<MaquetaEntity> productos = maquetasServicio.productosDeUnaCompra(c);
        maquetas = productos;
        //FacturaExporterPDF exporter = new FacturaExporterPDF(productos);
        //exporter.exportar(response);
        model.addAttribute("productos",productos);
        model.addAttribute("compra",c);
        model.addAttribute("total_compra", productos.stream()
                .mapToDouble(p -> p.getPrecio())
                .sum());
        return "public/factura";
    }

    @GetMapping("/exportarPDF/{id}")
    public void exportarCompraPDF(HttpServletResponse response, @PathVariable Integer id) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Compra_"+fechaActual+".pdf";

        response.setHeader(cabecera,valor);

        CompraEntity compra = compraServicio.obtenerCompraPorId(id);

        FacturaExporterPDF exporter = new FacturaExporterPDF(maquetas);
        exporter.exportar(response);

    }

    @GetMapping("/exportarExcel/{id}")
    public void exportarCompraExcel(HttpServletResponse response, @PathVariable Integer id) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Compra_"+fechaActual+".xlsx";

        response.setHeader(cabecera,valor);

        CompraEntity compra = compraServicio.obtenerCompraPorId(id);

        FacturaExporterExcel exporter = new FacturaExporterExcel(maquetas);
        exporter.exportar(response);

    }

   /* @GetMapping("/maquetas/{id}")
    public String mostrarMaqueta(Model model, @PathVariable Integer id) {
        MaquetaEntity producto = maquetasServicio.obtenerMaquetaPorId(id);
        if (producto != null) {
            model.addAttribute("producto",producto);
            return "/public/maqueta_detalle";//redirect si falla. Pd: se tendrá que cambiar
        }
        return "redirect:/public/maquetas";
    }*/

   @GetMapping({"/models","/","/maquetas",""})//url path
    public String listarMaquetas(Model model) {
        model.addAttribute("maquetas", maquetasServicio.listAll());
        return "public/maqueta";//html path
    }

    @GetMapping({"/maquetas/nuevo"})
    public String mostrarFormRegistroMaqueta(Model model) {
        //maqueta que le pasaremos al formulario
        MaquetaEntity maqueta = new MaquetaEntity();
        model.addAttribute("maqueta",maqueta);
        return "public/crear_maqueta";
    }

    @PostMapping("/maquetas")
    public String guardarMaqueta(@ModelAttribute("maqueta")MaquetaEntity maqueta/*, @RequestParam("file")MultipartFile file*/) {
        /*if (!file.isEmpty()) {
            String imagen = storageService.store(file);
            maqueta.setImage(MvcUriComponentsBuilder
                    .fromMethodName(FilesController.class,"serveFile",imagen).build().toUriString());
        }*/
        //recibimos el objeto que creamos para el formulario
        //agregamos métodos útiles a la Interfaz de servicio
        maquetasServicio.guardarMaqueta(maqueta);
        return "redirect:/public/maquetas";//volvemos a la página inicial
    }

    @GetMapping("/maquetas/mostrar/{id}")
    public String mostrarMaqueta(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("maqueta", maquetasServicio.obtenerMaquetaPorId(id));
        return "/public/maqueta_detalle";
    }

    @GetMapping("/maquetas/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("maqueta", maquetasServicio.obtenerMaquetaPorId(id));
        return "public/editar_maqueta";
    }

    @PostMapping("/maquetas/{id}")
    public String actualizarMaqueta(@PathVariable Integer id,
                                    @ModelAttribute("maqueta") MaquetaEntity maqueta,
                                    Model modelo) {
        MaquetaEntity maquetaExistente = maquetasServicio.obtenerMaquetaPorId(id);
        maquetaExistente.setIdMaqueta(maqueta.getIdMaqueta());
        //System.out.println(maquetaExistente.getIdMaqueta()); == 4
        maquetaExistente.setDescripcion(maqueta.getDescripcion());
        maquetaExistente.setMarca(maqueta.getMarca());
        maquetaExistente.setModelo(maqueta.getModelo());
        maquetaExistente.setPiloto(maqueta.getPiloto());
        maquetaExistente.setPrecio(maqueta.getPrecio());
        maquetasServicio.actualizarMaqueta(maquetaExistente);

        return "redirect:/public/maquetas";
    }

    @GetMapping("/maquetas/eliminar/{id}")
    public String eliminarMaqueta(@PathVariable Integer id) {
        maquetasServicio.eliminarMaquetas(id);
        return "redirect:/public/maquetas";
    }



}
