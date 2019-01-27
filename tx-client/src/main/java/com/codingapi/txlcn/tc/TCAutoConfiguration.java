/*
 * Copyright 2017-2019 CodingApi .
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
package com.codingapi.txlcn.tc;

import com.codingapi.txlcn.commons.runner.TxLcnApplicationRunner;
import com.codingapi.txlcn.logger.TxLoggerConfiguration;
import com.codingapi.txlcn.spi.sleuth.TxSleuthApiConfiguration;
import com.codingapi.txlcn.tc.config.DependenciesImportSelector;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description:
 * Date: 1/19/19
 *
 * @author ujued
 * @see EnableDistributedTransaction
 */
@Configuration
@ComponentScan
@Import({TxLoggerConfiguration.class, TxSleuthApiConfiguration.class, DependenciesImportSelector.class})
public class TCAutoConfiguration {

    /**
     * All initialization about TX-LCN
     *
     * @param applicationContext Spring ApplicationContext
     * @return TX-LCN custom runner
     */
    @Bean
    public ApplicationRunner txLcnApplicationRunner(ApplicationContext applicationContext) {
        return new TxLcnApplicationRunner(applicationContext);
    }
}
