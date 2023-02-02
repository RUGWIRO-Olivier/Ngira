FROM azul/zulu-openjdk-alpine:11
ENV PORT 9090
RUN apk update && apk add --no-cache tzdata curl bash && rm -rf /var/cache/apk/*
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
EXPOSE 9090
COPY target/*.jar /opt/intervention-manager
WORKDIR /opt
CMD ["java", "-jar", "intervention-manager"]