/*
 * Copyright 2019 ukuz90
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ukuz.piccolo.server.boot;

import io.github.ukuz.piccolo.api.PiccoloContext;
import io.github.ukuz.piccolo.api.service.registry.ServiceRegistry;
import io.github.ukuz.piccolo.api.spi.SpiLoader;

/**
 * @author ukuz90
 */
public class ServiceRegistryBoot implements BootJob {

    private ServiceRegistry registry;
    private PiccoloContext context;

    public ServiceRegistryBoot(ServiceRegistry registry, PiccoloContext context) {
        this.registry = registry;
        this.context = context;
    }

    @Override
    public void start() {
        //必须同步调用。
        registry.start(context);
    }

    @Override
    public void stop() {
        registry.stopAsync();
    }
}
