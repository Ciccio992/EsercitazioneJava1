package it.devlec.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EsempioLog {
    private static final Logger logger =  LogManager.getLogger(EsempioLog.class);

    public EsempioLog(){

    }
    public void stampaAltriLog(){
        logger.info("Informations");
        logger.info("Che scasso");
        logger.info("K.O.");
        logger.info("GAME OVER");
        logger.info("Bagarozzo da correggere");
        logger.info("Scarafone, correggere");
        logger.info("Dammi un istruzione");
        logger.info("La mia scheda madre si sta squagliando");
        logger.info("Ho sfasciato i circuiti");
    }
}
