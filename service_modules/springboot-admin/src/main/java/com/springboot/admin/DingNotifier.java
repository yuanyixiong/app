package com.springboot.admin;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.domain.values.InstanceId;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 袁毅雄
 * @description 服务变化发送至钉钉群
 * @date 2019/6/11
 */
@Component
@Slf4j
public class DingNotifier extends AbstractStatusChangeNotifier {

    private static final String DEFAULT_TEXT = "%s (%s)\nstatus is %s\n\n";

    /**
     * 后台java讨论群—ServiceChange预警
     */
    private final String ACCESS_TOKEN = "1651703977b0336d4cdddf37ce4ec858bdb7fc515d758ffc6f616e149a90749a";

    public DingNotifier(InstanceRepository repository) {
        super(repository);
    }

    @Value("${spring.profiles.active}")
    private String active;

    @Override
    protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
        return Mono.fromRunnable(() -> {
            log.info("ServiceChange预警,当前环境地址:" + active);
            /*
            if (!"prod".equals(active)) {
                return;
            }
            */
            if (event instanceof InstanceStatusChangedEvent) {
                InstanceStatusChangedEvent instanceStatusChangedEvent = (InstanceStatusChangedEvent) event;
                final String serviceName = instance.getRegistration().getName();
                final InstanceId instanceId = event.getInstance();
                log.info("ServiceChange预警,准备发送预警通知,当前服务为: {}({})", serviceName, instanceId);
                String serviceUrl = "http://172.16.89.150:8345/#/applications/" + instanceId + "/details";
                String content = String.format(DEFAULT_TEXT, serviceName, instanceId, instanceStatusChangedEvent.getStatusInfo().getStatus());
                content = content + serviceUrl + "\n CurrentDateTime is \n" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
                //SendMsgUtils.sendDingtalkMsg(content, ACCESS_TOKEN);
                System.out.println(content);
            }
        });
    }
}

