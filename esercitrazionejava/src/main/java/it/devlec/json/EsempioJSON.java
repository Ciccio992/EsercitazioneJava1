package it.devlec.json;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class EsempioJSON {
    private static final Logger logger = LogManager.getLogger(EsempioJSON.class);

    public void esempioJSONOggetto(){

        JSONObject jo = new JSONObject();
        jo.put("nome", "Giovanni");
        jo.put("eta", "22");
        jo.put("citta", "Lecce");
        logger.info("JSON "+ jo);

        JSONObject jo2 = new JSONObject();
        jo2.put("nome", "Gianni");
        jo2.put("eta", "41");
        jo2.put("citta", "Cerignola");
        logger.info("JSON "+ jo2);

        JSONObject jo3 = new JSONObject();
        jo3.put("nome", "Veronica");
        jo3.put("eta", "19");
        jo3.put("citta", "Trani");
        logger.info("JSON "+ jo3);

        JSONObject jo4 = new JSONObject();
        jo4.put("nome", "Franco");
        jo4.put("eta", "27");
        jo4.put("citta", "Polignano");
        logger.info("JSON "+ jo4);
    }
    public void esempioJSONArray(){
        JSONArray ja = new JSONArray();
        ja.put("Ciao a tutti");

        JSONObject jo = new JSONObject();
        jo.put("Nome", "Luca");
        jo.put("eta", "67");
        jo.put("citta", "Roma");
        logger.info("JSON "+ jo);

        JSONObject jo1 = new JSONObject();
        jo1.put("nome", "Giovanni");
        jo1.put("eta", "22");
        jo1.put("citta", "Lecce");
        logger.info("JSON "+ jo1);

        JSONObject jo2 = new JSONObject();
        jo2.put("nome", "Gianni");
        jo2.put("eta", "41");
        jo2.put("citta", "Cerignola");
        logger.info("JSON "+ jo2);

        JSONObject jo3 = new JSONObject();
        jo3.put("nome", "Veronica");
        jo3.put("eta", "19");
        jo3.put("citta", "Trani");
        logger.info("JSON "+ jo3);

        JSONObject jo4 = new JSONObject();
        jo4.put("nome", "Franco");
        jo4.put("eta", "27");
        jo4.put("citta", "Polignano");
        logger.info("JSON "+ jo4);

        ja.put(jo);
        logger.info("JSON "+ ja);
    }
}
