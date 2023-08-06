#!/bin/bash

APP_NAME="./target/school-app-0.0.1-SNAPSHOT.jar"
LOG_FILE="app.log"
PID_FILE="app.pid"

start() {
    if [ -f "$PID_FILE" ]; then
        echo "The application is already running. PID: $(cat $PID_FILE)"
    else
        nohup java -jar $APP_NAME >> $LOG_FILE 2>&1 &
        echo $! > $PID_FILE
        echo "Application started. PID: $(cat $PID_FILE)"
    fi
}

stop() {
    if [ -f "$PID_FILE" ]; then
        PID=$(cat $PID_FILE)
        kill $PID
        rm $PID_FILE
        echo "Application stopped."
    else
        echo "The application is not running."
    fi
}

restart() {
    stop
    sleep 5  # Give some time for the application to stop gracefully
    start
}

case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    restart)
        restart
        ;;
    *)
        echo "Usage: $0 {start|stop|restart}"
        exit 1
        ;;
esac

exit 0