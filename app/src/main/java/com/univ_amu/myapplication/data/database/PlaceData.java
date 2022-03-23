package com.univ_amu.myapplication.data.database;

import com.univ_amu.myapplication.data.Place;

public class PlaceData {

    public static Place[] populatePlacesData() {
        return new Place[] {
                new Place("1", "Basilique Notre Dame de la Garde", "30", 43.2841407240083, 5.3720638180472635, "@drawable/notre_dame.PNG"),
                new Place("2", "Parc National des Calanques", "480", 43.21825272833167, 5.431318868874061, ""),
                new Place("3", "Château d'If", "240", 43.28038497328065, 5.323662366907612, ""),
                new Place("4", "Mucem", "60", 43.29785879580998, 5.361095050707256, ""),
                new Place("5", "Le Vieux Port", "30", 43.294979949477245, 5.37307630212541, ""),
                new Place("6", "Le Panier", "60", 43.29989564647544, 5.3687950792252295, ""),
                new Place("7", "Île de frioul", "240", 43.274981147977634, 5.304374132132312, ""),
                new Place("8", "Palais Longchamps", "60", 43.30438399312286, 5.39534318736367, ""),
                new Place("9", "Cite Radieuse Le Corbusier", "30", 43.26177143595371, 5.397978595367164, ""),
                new Place("10", "Vallon des Auffes", "45",43.285305256277326, 5.3513472925813526, ""),
                new Place("11", "Cathedrale de la Major", "30", 43.29962539472599, 5.365329737639822, ""),
                new Place("12", "Orange Velodrome", "15", 43.2699519714636, 5.396520299007293, ""),
                new Place("13", "Calanque de Sormiou", "300", 43.211566438125544, 5.4220031053134, ""),
                new Place("14", "Palais du Pharo", "60", 43.29454572746838, 5.35892468551467, ""),
                new Place("15", "Le Maregraphe", "30", 43.278974661929354, 5.35411305042041, ""),
                new Place("16", "Abbaye Saint Victor", "60", 43.29040338690453, 5.364987900208376, ""),
                new Place("17", "Calanque de Morgiou", "240", 43.21287858220597, 5.4442700433743125, ""),
                new Place("18", "Musée d'Histoire de Marseille", "90", 43.2979783813653, 5.376062254830549, ""),
                new Place("19", "Parc Borély", "45", 43.260333979140555, 5.382354341888563, ""),
                new Place("20", "Centre de la Vieille Charite", "15", 43.3002609929302, 5.368433539488543, "")
        };
    }
}
