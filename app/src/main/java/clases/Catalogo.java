package clases;

import com.example.putiton.R;

import java.util.Arrays;
import java.util.List;

public class Catalogo {
    private static Producto MujerSudadera1 = new Producto(111, 0, "Sudadera Capucha Oversize Gráfico", "Graphic Oversize Hood Sweatshirt", 25.99);
    private static Producto MujerSudadera2 = new Producto(112, 1,"Sudadera Inicial", "Initial Sweatshirt", 25.99);
    private static Producto MujerSudadera3 = new Producto(113, 2,"Sudadera Básica Oversize Soft Touch", "Basic Oversize Soft Touch Sweatshirt", 19.99);
    private static Producto MujerSudadera4 = new Producto(114, 3,"Sudadera Gráfico Ondas", "Graphic Waves Sweatshirt", 25.99);
    private static Producto MujerPantalon1 = new Producto(121, 4,"Jeans Mom Fit Básicos", "Basic Fit Mom Jeans", 19.99);
    private static Producto MujerPantalon2 = new Producto(122, 5,"Pantalón Jogger Soft Touch", "Soft Touch Joggers", 19.99);
    private static Producto MujerPantalon3 = new Producto(123, 6,"Pantalón Culotte Canalé Soft Touch", "Culotte Soft Touch Trousers", 19.99);
    private static Producto MujerPantalon4 = new Producto(124, 7,"Pantalón Campana Tejido", "Fabric Wide-leg Trousers", 22.99);
    private static Producto MujerZapatos1 = new Producto(131, 8,"Botín Tacón Plataforma", "Graphic Oversize Hood Sweatshirt", 39.99);
    private static Producto MujerZapatos2 = new Producto(132, 9,"Bota Alta Tacón","Heeled High Boots",  49.99);
    private static Producto MujerZapatos3 = new Producto(133, 10,"Sandalia Tacón Tiras", "Heeled Straps Sandals",  25.99);
    private static Producto MujerZapatos4 = new Producto(134, 11,"Bota Acordonada Piso Track", "Chunky Track Sole Ankle Boots", 45.99);
    private static Producto MujerAccesorios1 = new Producto(141, 12,"Collar Dragón Plateado", "Silver Dragon Necklace", 3.99);
    private static Producto MujerAccesorios2 = new Producto(142, 13,"Pack 5 Anillos Dorados", "5-pack Gold Rings", 5.99);
    private static Producto MujerAccesorios3 = new Producto(143, 14,"Pack 2 Pendientes Aros Degradados","2-Pack Hoop Earrings", 4.99);
    private static Producto MujerAccesorios4 = new Producto(144, 15,"Gorra Básica Efecto Lavado", "Washed Effect Basic Cap", 9.99);
    private static Producto HombreSudadera1 = new Producto(211, 16,"Sudadera Capucha Detalle Stwd", "Hood Detail Stwd Sweatshirt", 25.99);
    private static Producto HombreSudadera2 = new Producto(212, 17,"Sudadera Gráfico Círculo", "Circle Graphic Sweatshirt", 25.99);
    private static Producto HombreSudadera3 = new Producto(213, 18,"Sudadera Parche Contraste", "Contrast Patch Sweatshirt", 25.99);
    private static Producto HombreSudadera4 = new Producto(214, 19,"Sudadera Ramones Logo", "Ramones Logo Sweatshirt", 29.99);
    private static Producto HombrePantalon1 = new Producto(221, 20,"Pantalón Jogger Detalle Cremallera", "Zipper Detail Joggers", 19.99);
    private static Producto HombrePantalon2 = new Producto(222, 21,"Jeans Wide Leg Delavados", "Wide-leg Jeans", 25.99);
    private static Producto HombrePantalon3 = new Producto(223, 22,"Pantalón Pinzas Wide Leg", "Wide-leg Trousers", 29.99);
    private static Producto HombrePantalon4 = new Producto(224, 23,"Pantalón Cargo Soft Knit", "Cargo Soft Knit Trousers", 29.99);
    private static Producto HombreZapatos1 = new Producto(231, 24,"Zapato Piso Track", "Chunky Track Sole Shoes", 39.99);
    private static Producto HombreZapatos2 = new Producto(232, 25,"Bota Acordonada Piso Track", "Chunky Track Sole Shoes", 39.99);
    private static Producto HombreZapatos3 = new Producto(233, 26,"Zapatillas Casual Piel", "Casual Fabric Trainers", 35.99);
    private static Producto HombreZapatos4 = new Producto(234, 27,"Bota Chelsea Piso Track", "Chelsea Track Sole Boots", 45.99);
    private static Producto HombreAccesorios1 = new Producto(241, 28,"Gafas Sol Aviador", "Aviator Sunglasses", 12.99);
    private static Producto HombreAccesorios2 = new Producto(242, 29,"Pack 3 Collares Ojo", "3-Pack Eye Necklace", 4.99);
    private static Producto HombreAccesorios3 = new Producto(243, 30,"Gorra Visera Contraste", "Constrast Cap", 7.99);
    private static Producto HombreAccesorios4 = new Producto(244, 31,"Cartera Ondas", "Waves Wallet", 9.99);

    public static List<Producto> catalogo = Arrays.asList(
            MujerSudadera1,
            MujerSudadera2,
            MujerSudadera3,
            MujerSudadera4,
            MujerPantalon1,
            MujerPantalon2,
            MujerPantalon3,
            MujerPantalon4,
            MujerZapatos1,
            MujerZapatos2,
            MujerZapatos3,
            MujerZapatos4,
            MujerAccesorios1,
            MujerAccesorios2,
            MujerAccesorios3,
            MujerAccesorios4,
            HombreSudadera1,
            HombreSudadera2,
            HombreSudadera3,
            HombreSudadera4,
            HombrePantalon1,
            HombrePantalon2,
            HombrePantalon3,
            HombrePantalon4,
            HombreZapatos1,
            HombreZapatos2,
            HombreZapatos3,
            HombreZapatos4,
            HombreAccesorios1,
            HombreAccesorios2,
            HombreAccesorios3,
            HombreAccesorios4);

    public static int getImageId(int n){
        int[] imageIds = {
                R.drawable.msoverize,
                R.drawable.msinicial,
                R.drawable.msbasica,
                R.drawable.msondas,
                R.drawable.mpjeans,
                R.drawable.mpjogger,
                R.drawable.mpculotte,
                R.drawable.mpcampana,
                R.drawable.mzplataforma,
                R.drawable.mzalta,
                R.drawable.mzsandalias,
                R.drawable.mzbota,
                R.drawable.macollar,
                R.drawable.maanillos,
                R.drawable.mapendientes,
                R.drawable.magorra,
                R.drawable.hsdetalle,
                R.drawable.hsgrafico,
                R.drawable.hsparche,
                R.drawable.hsramones,
                R.drawable.hpjogger,
                R.drawable.hpjeans,
                R.drawable.hppinzas,
                R.drawable.hpcargo,
                R.drawable.hzpiso,
                R.drawable.hzbotacordones,
                R.drawable.hzzapatillas,
                R.drawable.hzbotach,
                R.drawable.hagafas,
                R.drawable.hacollar,
                R.drawable.hagorra,
                R.drawable.hacartera
        };
        return imageIds[n];
    }
}
