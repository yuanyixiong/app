package com.service.bridge.client.user;

import com.service.bridge.config.annotation.UserClient;
import com.service.bridge.fallback.user.UserAuthRemoteFallback;
import com.service.bridge.service.user.UserAuthRemoteService;

@UserClient(fallbackFactory = UserAuthRemoteFallback.class)
public interface UserAuthRemoteClient extends UserAuthRemoteService {
}
