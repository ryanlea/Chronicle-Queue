package net.openhft.chronicle.network;

import org.jetbrains.annotations.Nullable;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimpleSessionDetailsProvider implements SessionDetailsProvider {

    private final Map<Class, Object> infoMap = new HashMap<>();
    private String userId;
    private long connectTimeMS;
    private InetSocketAddress clientAddress;
    private String securityToken;

    @Override
    public void setConnectTimeMS(long connectTimeMS) {
        this.connectTimeMS = connectTimeMS;
    }

    @Override
    public void setClientAddress(InetSocketAddress connectionAddress) {
        this.clientAddress = connectionAddress;
    }

    @Override
    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public UUID sessionId() {
        return null;
    }

    @Nullable
    @Override
    public String userId() {
        return userId;
    }

    @Nullable
    @Override
    public String securityToken() {
        return securityToken;
    }

    @Nullable
    @Override
    public InetSocketAddress clientAddress() {
        return clientAddress;
    }

    @Override
    public long connectTimeMS() {
        return connectTimeMS;
    }

    @Override
    public <I> void set(Class<I> infoClass, I info) {
        infoMap.put(infoClass, info);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I> I get(Class<I> infoClass) {
        return (I) infoMap.get(infoClass);
    }
}