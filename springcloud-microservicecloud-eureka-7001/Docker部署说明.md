docker部署根据https://lijinhongpassion.github.io/codeant/daba.html上的流程操作完成后，
制作镜像没有问题，但是在生成容器后运行会报错
No main manifest attribute, in XXX.jar
该错误说明没有指出mian方法的具体位置
更改如下
打开该子项目的pom文件

```xml
<plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- 指出main方法的位置 -->
                    <mainClass>com.cqut.li.springcloud.Eureka_Server7001_App</mainClass>
                </configuration>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
```
