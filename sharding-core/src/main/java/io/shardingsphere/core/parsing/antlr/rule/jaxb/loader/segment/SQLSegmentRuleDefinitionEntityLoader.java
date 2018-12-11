/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.parsing.antlr.rule.jaxb.loader.segment;

import com.google.common.base.Preconditions;
import io.shardingsphere.core.parsing.antlr.rule.jaxb.entity.segment.SQLSegmentRuleDefinitionEntity;
import io.shardingsphere.core.parsing.antlr.rule.jaxb.loader.RuleDefinitionEntityLoader;
import lombok.SneakyThrows;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;

/**
 * SQL segment rule definition entity loader for JAXB.
 *
 * @author zhangliang
 */
public final class SQLSegmentRuleDefinitionEntityLoader implements RuleDefinitionEntityLoader {
    
    @Override
    @SneakyThrows
    public SQLSegmentRuleDefinitionEntity load(final String sqlSegmentRuleDefinitionFile) {
        InputStream inputStream = SQLSegmentRuleDefinitionEntityLoader.class.getClassLoader().getResourceAsStream(sqlSegmentRuleDefinitionFile);
        Preconditions.checkNotNull(inputStream, "Cannot load SQL segment rule definition file :%s, ", sqlSegmentRuleDefinitionFile);
        return (SQLSegmentRuleDefinitionEntity) JAXBContext.newInstance(SQLSegmentRuleDefinitionEntity.class).createUnmarshaller().unmarshal(inputStream);
    }
}
