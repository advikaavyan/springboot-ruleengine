### VERY USEFUL TO TEST Kubernetes Resources locally ###

Create skaffold.yaml with following
`
1. apiVersion: skaffold/v2beta19
2. kind: Config
3. metadata:
4. name: adaptor-app
5. build:
6. artifacts:
7. - image: advikaavyan/adaptor-app
8. jib:
9. 
10.         args:
11.           - -Pjib
12. tagPolicy:
13. gitCommit: { }`

### also create k8s folder under the root spring boot application and have all the yamls
#### command "skaffold dev" it will read all the yamls under k8s and ctreate the resources under kubernetes default namespace automatically also it listen any changes in yamls etc and applies automatically so need to fire the command again n again very good to validate PODs etc

To run the skafflod on local 
1. we need to download skafflod123.exe from google 
2. then rename it as skaffol.exe
3. add the path in env path 
4. now run skaffol verion

if gett ing any error due to docker .... i followed 
1. https://download.docker.com/win/static/stable/x86_64/
2. added path to env path and again run
3. skaffold dev it worked 