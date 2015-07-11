package net.samagames.hydroangeas.server.client;

import net.samagames.hydroangeas.common.protocol.AskForClientActionPacket;

import java.util.HashMap;
import java.util.UUID;

/**
 * This file is a part of the SamaGames Project CodeBase
 * This code is absolutely confidential.
 * Created by Geekpower14 on 25/06/2015.
 * (C) Copyright Elydra Network 2014 & 2015
 * All rights reserved.
 */
public class MinecraftServerS {

    private HydroClient client;
    private UUID uuid;
    private boolean coupaingServer;
    private String game;
    private String map;
    private int minSlot;
    private int maxSlot;
    private HashMap<String, String> options;

    private boolean started;

    private int weight;

    private int port;

    public MinecraftServerS(HydroClient client, String game, String map)
    {
        this(client, game, map, 0, 0, new HashMap<>());
    }

    public MinecraftServerS(HydroClient client, String game, String map, int minSlot, int maxSlot, HashMap<String, String> options)
    {
        this(client, UUID.randomUUID(), game, map, minSlot, maxSlot, options);
    }

    public MinecraftServerS(HydroClient client, UUID uuid, String game, String map, int minSlot, int maxSlot, HashMap<String, String> options)
    {
        this.client = client;
        this.uuid = uuid;
        this.game = game;
        this.map = map;
        this.minSlot = minSlot;
        this.maxSlot = maxSlot;
        this.options = options;

        this.coupaingServer = false;
    }

    public void shutdown()
    {
        client.getInstance().getConnectionManager().sendPacket(client,
                new AskForClientActionPacket(client.getUUID(), AskForClientActionPacket.ActionCommand.SERVEREND, getServerName()));
    }

    public void onShutdown()
    {
        //If we need to save some data after shutdown
    }

    public void changeUUID()
    {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUUID()
    {
        return this.uuid;
    }

    public String getGame()
    {
        return this.game;
    }

    public String getMap()
    {
        return this.map;
    }

    public String getServerName()
    {
        return this.game + "_" + this.uuid.toString().split("-")[0];
    }

    public int getMinSlot()
    {
        return this.minSlot;
    }

    public int getMaxSlot()
    {
        return this.maxSlot;
    }

    public HashMap<String, String> getOptions()
    {
        return this.options;
    }

    public boolean isCoupaingServer()
    {
        return this.coupaingServer;
    }

    public void setCoupaingServer(boolean isCoupaing)
    {
        this.coupaingServer = isCoupaing;
    }

    public boolean isStarted()
    {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}