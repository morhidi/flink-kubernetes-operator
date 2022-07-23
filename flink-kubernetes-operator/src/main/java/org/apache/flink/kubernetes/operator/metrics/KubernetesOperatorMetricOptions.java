/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.kubernetes.operator.metrics;

import org.apache.flink.configuration.ConfigOption;
import org.apache.flink.configuration.ConfigOptions;

/** Configuration options for metrics. */
public class KubernetesOperatorMetricOptions {

    public static final ConfigOption<Boolean> OPERATOR_JVM_METRICS_ENABLED =
            ConfigOptions.key("kubernetes.operator.jvm.metrics.enabled")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription("Enable Kubernetes Operator JVM metrics.");

    public static final ConfigOption<Boolean> OPERATOR_JOSDK_METRICS_ENABLED =
            ConfigOptions.key("kubernetes.operator.josdk.metrics.enabled")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            "Enable forwarding of Java Operator SDK metrics to the Flink metric registry.");

    public static final ConfigOption<Boolean> OPERATOR_KUBERNETES_CLIENT_METRICS_ENABLED =
            ConfigOptions.key("kubernetes.operator.kubernetes.client.metrics.enabled")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            "Enable KubernetesClient metrics for measuring the HTTP traffic to the Kubernetes API Server.");

    public static final ConfigOption<Boolean> OPERATOR_RESOURCE_METRICS_ENABLED =
            ConfigOptions.key("kubernetes.operator.resource.metrics.enabled")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            "Enables metrics for FlinkDeployment and FlinkSessionJob custom resources.");

    public static final ConfigOption<Boolean> OPERATOR_LIFECYCLE_METRICS_ENABLED =
            ConfigOptions.key("kubernetes.operator.resource.lifecycle.metrics.enabled")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            "Enable resource lifecycle state metrics. This enables both state and transition counts/histograms.");

    public static final ConfigOption<Boolean> OPERATOR_LIFECYCLE_NAMESPACE_HISTOGRAMS_ENABLED =
            ConfigOptions.key("kubernetes.operator.resource.lifecycle.namespace.histograms.enabled")
                    .booleanType()
                    .defaultValue(true)
                    .withDescription(
                            "In addition to the system level histograms, enable per namespace tracking of state and transition times.");

    public static final ConfigOption<Integer> OPERATOR_METRICS_HISTOGRAM_SAMPLE_SIZE =
            ConfigOptions.key("kubernetes.operator.metrics.histogram.sample.size")
                    .intType()
                    .defaultValue(1000)
                    .withDescription(
                            "Defines the number of measured samples when calculating statistics.");

    public static final ConfigOption<String> SCOPE_NAMING_KUBERNETES_OPERATOR =
            ConfigOptions.key("metrics.scope.k8soperator.system")
                    .stringType()
                    .defaultValue("<host>.k8soperator.<namespace>.<name>.system")
                    .withDeprecatedKeys("metrics.scope.k8soperator")
                    .withDescription(
                            "Defines the scope format string that is applied to all metrics scoped to the kubernetes operator.");

    public static final ConfigOption<String> SCOPE_NAMING_KUBERNETES_OPERATOR_RESOURCENS =
            ConfigOptions.key("metrics.scope.k8soperator.resourcens")
                    .stringType()
                    .defaultValue("<host>.k8soperator.<namespace>.<name>.namespace.<resourcens>")
                    .withDescription(
                            "Defines the scope format string that is applied to all metrics scoped to the kubernetes operator resource namespace.");

    public static final ConfigOption<String> SCOPE_NAMING_KUBERNETES_OPERATOR_RESOURCE =
            ConfigOptions.key("metrics.scope.k8soperator.resource")
                    .stringType()
                    .defaultValue(
                            "<host>.k8soperator.<namespace>.<name>.resource.<resourcens>.<resourcename>")
                    .withDescription(
                            "Defines the scope format string that is applied to all metrics scoped to the kubernetes operator resource.");
}
