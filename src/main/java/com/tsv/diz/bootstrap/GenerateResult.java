/*
package com.tsv.diz.bootstrap;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GenerateResult implements CommandLineRunner {

	private double score;
	private double pretDeLaConverted = 0;
	private double pretPanaLaConverted = 0;
	private int anFabrDeLaConverted = 0;
	private int anFabrPanaLaConverted = 0;

	private List<String> costuriMiciDeIntretinere = Arrays.asList("toyota", "honda", "mitsubishi", "mazda", "nissan",
			"volkswagen", "hyundai", "dacia", "opel", "skoda", "suzuki", "daewoo", "kia", "seat");
	private List<String> costuriMediiDeIntretinere = Arrays.asList("ford", "land rover", "chevrolet", "jeep", "renault",
			"peugeot", "citroen", "daihatsu");
	private List<String> costuriMariDeIntretinere = Arrays.asList("bmw", "audi", "volvo", "chrysler", "dodge", "jaguar",
			"alfa romeo", "porsche", "mercedes-benz");

	private List<String> dimensiuniMici = Arrays.asList("147", "gt", "a1", "a2", "a3", "tt", "seria 1", "kalos", "spark", "c1",
			"c2", "c3", "c4", "sandero", "matiz", "sirion", "bravo", "grande punto", "punto", "panda", "stilo",
			"fiesta", "focus", "ka", "streetka", "civic", "insight", "coupe", "getz", "i10", "i20", "i30", "ix20",
			"cee'd", "rio", "venga", "2", "rx-8", "colt", "space star", "micra", "agila", "astra", "corsa", "tigra",
			"107", "206", "207", "boxster", "twingo", "ibiza", "leon", "fabia", "alto", "spalsh", "auris", "aygo",
			"yaris", "beetle", "eos", "fox", "golf", "lupo", "scirocco", "v40");

	private List<String> dimensiuniMedii = Arrays.asList("156", "159", "166", "a4", "a5", "a6", "a8", "seria 3", "seria 5",
			"seria 6", "seria 7", "aveo", "cruze", "lacetti", "c4 picasso", "c5", "c6", "1300", "1310", "logan",
			"duster", "nubira", "cielo", "avenger", "caliber", "challenger", "charger", "albea", "croma", "linea",
			"qubo", "sedici", "tipo", "mondeo", "accord", "accent", "elantra", "sonata", "s-type", "x-type", "xf", "xj",
			"carens", "cerato", "optima", "3", "5", "6", "626", "premacy", "lancer", "almera", "tiida", "insignia",
			"omega", "rekord", "signum", "vectra", "zafira", "3008", "306", "307", "308", "406", "407", "5008", "508",
			"607", "espace", "fluence", "grand scenic", "kangoo", "laguna", "latitude", "megane", "scenic", "symbol",
			"alhambra", "altea", "cordoba", "exeo", "toledo", "felicia", "octavia", "rapid", "roomster", "superb",
			"yeti", "sx4", "avensis", "corolla", "prius", "tacoma", "bora", "caddy", "jetta", "passat", "passat cc",
			"phaeton", "c30", "c70", "s40", "s80", "s60", "s90", "v50", "v60");

	List<String> dimensiuniMari = Arrays.asList("q5", "q7", "x1", "x3", "x5", "captiva", "300c", "grand voyager", "c8",
			"terios", "nitro", "ram", "doblo", "ducato", "scudo", "fusion", "galaxy", "kuga", "s-max", "transit",
			"cr-v", "jazz", "galloper", "h-1", "ix35", "ix55", "santa fe", "terracan", "tucson", "cherokee", "compass",
			"grand cherokee", "wrangler", "sorento", "soul", "sportage", "defender", "discovery", "discovery sport",
			"freelancer", "range rover", "range rover evoque", "range rover sport", "cx-7", "asx", "l200", "outlander",
			"pajero", "pajero pinin", "juke", "pathfinder", "patrol", "primastar", "qashqai", "terrano", "x-trail",
			"antara", "combo", "frontera", "meriva", "movano", "vivaro", "4007", "bipper", "expert", "cayenne",
			"koleos", "traffic", "grand vitara", "ignis", "jimmy", "samurai", "vitara", "land cruiser", "caravelle",
			"tiguan", "touareg", "touran", "xc60");

	@Override
	public void run(String... args) throws Exception {
		System.out.println(generateResult("dacia", "logan", "5000", "10000", "2008", "2012"));

	}

	public double generateResult(String marcaId, String modelId, String pretDeLa, String pretPanaLa, String anFabrDeLa,
			String anFabrPanaLa) {
		score = 0;
		pretDeLaConverted = 0;
		pretPanaLaConverted = 0;
		anFabrDeLaConverted = 0;
		anFabrPanaLaConverted = 0;

		if (costuriMiciDeIntretinere.contains(marcaId.toLowerCase())) {
			score = 0;
		} else if (costuriMediiDeIntretinere.contains(marcaId.toLowerCase())) {
			score += 3.0;
		} else {
			score += 6.0;
		}

		if (dimensiuniMici.contains(modelId.toLowerCase())) {
			score += 0.5;
		} else if (dimensiuniMedii.contains(modelId.toLowerCase())) {
			score += 0.75;
		} else {
			score += 1.0;
		}
		if (!pretDeLa.isEmpty()) {
			pretDeLaConverted = Double.parseDouble(pretDeLa);
			if (pretDeLaConverted > 20_000) {
				score += 0.5;
			} else if (pretDeLaConverted >= 10_000 && pretDeLaConverted <= 20_000) {
				score += 0.25;
			} else {
				score += 0.1;
			}
		} else {
			score += 0.5;
		}

		if (!pretPanaLa.isEmpty()) {
			pretPanaLaConverted = Double.parseDouble(pretPanaLa);
			if (pretPanaLaConverted > 20_000) {
				score += 0.5;
			} else if (pretPanaLaConverted >= 10_000 && pretPanaLaConverted <= 20_000) {
				score += 0.25;
			} else {
				score += 0.1;
			}
		} else {
			score += 0.5;
		}

		if (!anFabrDeLa.isEmpty()) {
			anFabrDeLaConverted = Integer.parseInt(anFabrDeLa);
			if (anFabrDeLaConverted >= 2018) {
				score += 0.5;
			} else if (anFabrDeLaConverted >= 2010 && anFabrDeLaConverted <= 2017) {
				score += 0.25;
			} else {
				score += 0.1;
			}
		} else {
			score += 0.5;
		}

		if (!anFabrPanaLa.isEmpty()) {
			anFabrPanaLaConverted = Integer.parseInt(anFabrPanaLa);
			if (anFabrPanaLaConverted > 2018) {
				score += 0.5;
			} else if (anFabrPanaLaConverted >= 2010 && anFabrPanaLaConverted <= 2017) {
				score += 0.25;
			} else {
				score += 0.1;
			}
		} else {
			score += 0.5;
		}

		return Math.round(score * 100.0) / 100.0;

	}

}
*/