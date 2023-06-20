# 将网页自动上传部署到服务器上的

scp -i "C:\Users\shiwenbo\.ssh\ubuntu20_server_ali.pem"  -r "F:\dataFileForAll\Pros\javaPros\Java2022Soft\web\dist" root@boer.ink:/www/wwwroot/boer.ink/web

scp -i "C:\Users\shiwenbo\.ssh\ubuntu20_server_ali.pem"  -r "F:\dataFileForAll\Pros\javaPros\Java2022Soft\web\images" root@boer.ink:/www/wwwroot/boer.ink/web

scp -i "C:\Users\shiwenbo\.ssh\ubuntu20_server_ali.pem"  -r "F:\dataFileForAll\Pros\javaPros\Java2022Soft\web\src" root@boer.ink:/www/wwwroot/boer.ink/web

# 用edge打开上传的网址
start msedge 