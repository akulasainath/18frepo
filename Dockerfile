############################################################
# Dockerfile to build Ventera 18f Prototype Application 
# in a Docker Container 
############################################################

# Set the base image to Apache HTTPD
FROM httpd:2.4

# File Author / Maintainer
MAINTAINER Ventera Corporation

# Copy the application files to the container's Apache directory 
COPY /18frepo/18FDemo/web /usr/local/apache2/htdocs/web 

# Expose TCP Port 80 so the container's Apache web server
# will be accessible to clients
EXPOSE 80
