FROM websphere-liberty:webProfile7
LABEL maintainer="IBM Java Engineering at IBM Cloud"
COPY /target/liberty/wlp/usr/servers/defaultServer /config/
# Grant write access to apps folder, this is to support old and new docker versions.
# Liberty document reference : https://hub.docker.com/_/websphere-liberty/
USER root
RUN chmod g+w /config/apps
USER 1001
# Install required features if not present, install APM Data Collector
RUN installUtility install --acceptLicense defaultServer && installUtility install --acceptLicense apmDataCollector-7.4
ENV LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/lib:/opt/ibm/wlp/usr/extension/liberty_dc/toolkit/lib/lx8266 \
 JVM_ARGS="$JVM_ARGS -agentlib:am_ibm_16=defaultServer -Xbootclasspath/p:/opt/ibm/wlp/usr/extension/liberty_dc/toolkit/lib/bcm-bootstrap.jar -Xverbosegclog:/logs/gc.log,1,10000 -verbosegc -Djava.security.policy=/opt/ibm/wlp/usr/extension/liberty_dc/itcamdc/etc/datacollector.policy -Dliberty.home=/opt/ibm/wlp"

# Upgrade to production license if URL to JAR provided
ARG LICENSE_JAR_URL
RUN \ 
  if [ $LICENSE_JAR_URL ]; then \
    wget $LICENSE_JAR_URL -O /tmp/license.jar \
    && java -jar /tmp/license.jar -acceptLicense /opt/ibm \
    && rm /tmp/license.jar; \
  fi
