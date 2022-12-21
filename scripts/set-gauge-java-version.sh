#!/usr/bin/env bash
SCRIPT="gauge -v | sed -n '/java [(-)]/p' | cut -d '(' -f2 | cut -d ')' -f1"
GAUGE_JAVA_VERSION=$(eval $SCRIPT)
echo "gauge_java="$GAUGE_JAVA_VERSION > ./src/test/resources/vm-gauge.properties
echo $GAUGE_JAVA
case "$OSTYPE" in
  linux*) echo " Added gauge java env for LINUX"
  export GAUGE_JAVA=$GAUGE_JAVA_VERSION; ;;
  msys*)
  export GAUGE_JAVA=$GAUGE_JAVA_VERSION;
  setx GAUGE_JAVA $GAUGE_JAVA_VERSION;
 echo "Added gauge java env for WINDOWS" ;;
esac
