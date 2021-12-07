package net.killarexe.jlwin.util.discord;

import club.minnced.discord.rpc.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DiscordController {

    /**
     * Date: 29/05/21
     * @author Killar.exe
     * @version 0.1a
     */

    private String state;
    private String details;
    private String largeImageText;
    private String smallImageText;
    private final String applicationId;
    private final String steamId;

    private final Logger logger = LogManager.getLogger();

    /**
     * Init DiscordController and setup the RPC
     * @param details: details for the RPC
     * @param state: state for the RPC
     * @param largeImageText: large image to show in the RPC
     * @param smallImageText: small image to show in the RPC
     * @param applicationId: app/bot ID (for RPC Name)
     * @param steamId: for steam (useless)
     */
    public DiscordController(String details, String state, String largeImageText, String smallImageText, String applicationId, String steamId) {
        this.state = state;
        this.details = details;
        this.largeImageText = largeImageText;
        this.smallImageText = smallImageText;
        this.applicationId = applicationId;
        this.steamId = steamId;

        DiscordRPC rpc = DiscordRPC.INSTANCE;
        DiscordRichPresence presence = new DiscordRichPresence();
        DiscordEventHandlers handlers = new DiscordEventHandlers();

        handlers.ready = (user) -> logger.info("Discord RPC Ready!");

        if(applicationId != null) {
            rpc.Discord_Initialize(applicationId, handlers, true, steamId);
        }else{
            rpc.Discord_Initialize("848204033520304188", handlers, true, steamId);
        }

        presence.startTimestamp = System.currentTimeMillis() / 1000; // epoch second
        presence.endTimestamp   = presence.startTimestamp + 20;
        presence.details = details;
        presence.state = state;
        presence.largeImageText = largeImageText;
        presence.smallImageText = smallImageText;
        rpc.Discord_UpdatePresence(presence);
        logger.info("Discord RPC started:\n" +
                " Settings:\n" +
                " details:" + details + " state: " + state + " largeImageText: " + largeImageText + " smallImageText: " + smallImageText);

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                rpc.Discord_RunCallbacks();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    rpc.Discord_Shutdown();
                    break;
                }
            }
        }, "RPC-Callback-Handler");
        thread.start();
    }

    /**
     * Get state
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * Set state
     * @param state: state for the RPC
     */
    public void setState(String state) {
        logger.debug("Set State to: " + state);
        this.state = state;
    }

    /**
     * Get details
     * @return
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set details
     * @param details: details for the RPC
     */
    public void setDetails(String details) {
        logger.debug("Set Details to: " + details);
        this.details = details;
    }

    /**
     * Get Large Image
     * @return
     */
    public String getLargeImageText() {
        return largeImageText;
    }

    /**
     * Set Large Image
     * @param largeImageText: large image id for the RPC
     */
    public void setLargeImageText(String largeImageText) {
        logger.debug("Set LagreImageText to: " + largeImageText);
        this.largeImageText = largeImageText;
    }

    /**
     * Get Small Image
     * @return
     */
    public String getSmallImageText() {
        return smallImageText;
    }

    /**
     * Set Small Image
     * @param smallImageText: small image id for the RPC
     */
    public void setSmallImageText(String smallImageText) {
        logger.debug("Set SmallImageText to: " + smallImageText);
        this.smallImageText = smallImageText;
    }

    /**
     * Get App/Bot Id;
     * @return
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Get Steam Id;
     * @return
     */
    public String getSteamId() {
        return steamId;
    }
}
