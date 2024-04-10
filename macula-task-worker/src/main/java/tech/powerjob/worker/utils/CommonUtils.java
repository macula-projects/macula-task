/*
 * Copyright (c) 2024 Macula
 *    macula.dev, China
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package tech.powerjob.worker.utils;

import org.apache.commons.lang3.StringUtils;
import tech.powerjob.worker.core.processor.TaskContext;

/**
 * <p>
 * <b>CommonUtils</b> 助手类
 * </p>
 *
 * @author Rain
 * @since 2024/3/28
 */
public class CommonUtils {

    private CommonUtils() {

    }

    public static String parseParams(TaskContext context) {
        // 工作流中的总是优先使用 jobParams
        if (context.getWorkflowContext().getWfInstanceId() != null) {
            return context.getJobParams();
        }
        if (StringUtils.isNotEmpty(context.getInstanceParams())) {
            return context.getInstanceParams();
        }
        return context.getJobParams();
    }
}
