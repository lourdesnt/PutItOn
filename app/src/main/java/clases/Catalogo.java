package clases;

import com.example.putiton.R;

import java.util.Arrays;
import java.util.List;

public class Catalogo {
    private static Producto MujerSudadera1 = new Producto(111, 0, "Sudadera Capucha Oversize Gráfico", 25.99);
    private static Producto MujerSudadera2 = new Producto(112, 1,"Sudadera Inicial", 25.99);
    private static Producto MujerSudadera3 = new Producto(113, 2,"Sudadera Básica Oversize Soft Touch", 19.99);
    private static Producto MujerSudadera4 = new Producto(114, 3,"Sudadera Gráfico Ondas", 25.99);
    private static Producto MujerPantalon1 = new Producto(121, 4,"Jeans Mom Fit Básicos", 19.99);
    private static Producto MujerPantalon2 = new Producto(122, 5,"Pantalón Jogger Soft Touch", 19.99);
    private static Producto MujerPantalon3 = new Producto(123, 6,"Pantalón Culotte Canalé Soft Touch", 19.99);
    private static Producto MujerPantalon4 = new Producto(124, 7,"Pantalón Campana Tejido", 22.99);
    private static Producto MujerZapatos1 = new Producto(131, 8,"Botín Tacón Plataforma", 39.99);
    private static Producto MujerZapatos2 = new Producto(132, 9,"Bota Alta Tacón", 49.99);
    private static Producto MujerZapatos3 = new Producto(133, 10,"Sandalia Tacón Tiras", 25.99);
    private static Producto MujerZapatos4 = new Producto(134, 11,"Bota Acordonada Piso Track", 45.99);
    private static Producto MujerAccesorios1 = new Producto(141, 12,"Collar Dragón Plateado", 3.99);
    private static Producto MujerAccesorios2 = new Producto(142, 13,"Pack 5 Anillos Dorados", 5.99);
    private static Producto MujerAccesorios3 = new Producto(143, 14,"Pack 2 Pendientes Aros Degradados", 4.99);
    private static Producto MujerAccesorios4 = new Producto(144, 15,"Gorra Básica Efecto Lavado", 9.99);
    private static Producto HombreSudadera1 = new Producto(211, 16,"Sudadera Capucha Detalle Stwd", 25.99);
    private static Producto HombreSudadera2 = new Producto(212, 17,"Sudadera Gráfico Círculo", 25.99);
    private static Producto HombreSudadera3 = new Producto(213, 18,"Sudadera Parche Contraste", 25.99);
    private static Producto HombreSudadera4 = new Producto(214, 19,"Sudadera Ramones Logo", 29.99);
    private static Producto HombrePantalon1 = new Producto(221, 20,"Pantalón Jogger Detalle Cremallera", 19.99);
    private static Producto HombrePantalon2 = new Producto(222, 21,"Jeans Wide Leg Delavados", 25.99);
    private static Producto HombrePantalon3 = new Producto(223, 22,"Pantalón Pinzas Wide Leg", 29.99);
    private static Producto HombrePantalon4 = new Producto(224, 23,"Pantalón Cargo Soft Knit", 29.99);
    private static Producto HombreZapatos1 = new Producto(231, 24,"Zapato Piso Track", 39.99);
    private static Producto HombreZapatos2 = new Producto(232, 25,"Bota Acordonada Piso Track", 39.99);
    private static Producto HombreZapatos3 = new Producto(233, 26,"Zapatillas Casual Piel", 35.99);
    private static Producto HombreZapatos4 = new Producto(234, 27,"Bota Chelsea Piso Track", 45.99);
    private static Producto HombreAccesorios1 = new Producto(241, 28,"Gafas Sol Aviador", 12.99);
    private static Producto HombreAccesorios2 = new Producto(242, 29,"Pack 3 Collares Ojo", 4.99);
    private static Producto HombreAccesorios3 = new Producto(243, 30,"Gorra Visera Contraste", 7.99);
    private static Producto HombreAccesorios4 = new Producto(244, 31,"Cartera Ondas", 9.99);

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
