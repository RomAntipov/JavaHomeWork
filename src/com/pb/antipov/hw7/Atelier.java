package com.pb.antipov.hw7;

public class Atelier {
    public static void main(String[] args) {
        Tshirt tshirt1 = new Tshirt(Size.XS, 100.0f, "серый");
        Tshirt tshirt2 = new Tshirt(Size.M, 120.0f, "белый");
        Tie tie1 = new Tie(Size.S, 200.0f, "черный");
        Tie tie2 = new Tie(Size.M, 600.0f, "серый");
        Pants pants1 = new Pants(Size.L, 500f,"черный");
        Pants pants2 = new Pants(Size.XXS, 300f,"зелёный");
        Skirt skirt1 = new Skirt(Size.M, 500f, "красный");
        Skirt skirt2 = new Skirt(Size.L, 700f, "бежевый");



        Clothes[] clo = {tshirt1, tshirt2, tie1, tie2, pants1, pants2, skirt1, skirt2};

        dressMan(clo);
        dressWomen(clo);

    }

    static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда");
        for (Clothes cl : clothes){
            if(cl instanceof ManClothes){
                ((ManClothes) cl).dressMan();
            }
        }
    }

    static void dressWomen(Clothes[] clothes){
        System.out.println("Женская одежда");
        for (Clothes cl : clothes) {
            if(cl instanceof WomenClothes){
                ((WomenClothes) cl).dressWomen();
            }
        }
    }

}
