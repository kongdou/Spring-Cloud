Consul集群搭建(版本0.7.0)
===
1.下载安装consul
---
	-https://www.consul.io/downloads.html

2.主机规划
---
| 主机名称| Ip | 作用 |是否允许远程访问|
| ------ | ------ | ------ | ------ |
| node0 | 172.21.16.16(内)/62.234.169.232(外) | consul server | 是 |
| node1 | 172.21.16.9(内)/62.234.206.29(外) | consul server | 否 |
| node2 | 172.21.16.14(内)/62.234.175.39(外) | consul server | 是 |

3.节点搭建
---
- 启动node0(172.21.16.16)机器上的Consul：
```
./consul agent -data-dir /tmp/node0 -node=node0 -bind=172.21.16.16 -datacenter=dc1 -ui -client=172.21.16.16 -server -bootstrap-expect 1
```
- 启动node1(172.21.16.9)机器上的Consul：
```
./consul agent -data-dir /tmp/node1 -node=node1 -bind=172.21.16.9 -datacenter=dc1 -ui
```
- 启动node2(172.21.16.14)机器上的Consul：
```
./consul agent -data-dir /tmp/node2 -node=node2 -bind=172.21.16.14 -datacenter=dc1 -ui -client=172.21.16.14
```
- 将node1(172.21.16.9)节点加入到node0(172.21.16.16)上（在node1机器上执行）：
```
./consul join 172.21.16.16 //前提，开通node0的8301端口(firewall-cmd --add-port=8301/tcp)
```
- 将node2(172.21.16.14)节点加入到node0(172.21.16.16)上（在node2机器上执行）：
```
./consul join -rpc-addr=172.21.16.14:8400 172.21.16.16
```
- 集群搭建完成，在node1(172.21.16.9)上查看当前节点：
```
consul members -rpc-addr=172.21.16.16:8400
```
结果：
Node   Address            Status  Type    Build  Protocol  DC
node0  172.21.16.16:8301  alive   server  0.7.0  2         dc1
node1  172.21.16.9:8301   alive   client  0.7.0  2         dc1
node2  172.21.16.14:8301  alive   client  0.7.0  2         dc1


Consul集群搭建(版本1.3.0)
===
1.下载安装consul
---
	-https://www.consul.io/downloads.html

2.主机规划
---
| 主机名称| Ip | 作用 |是否允许远程访问|
| ------ | ------ | ------ | ------ |
| node0 | 172.21.16.16(内)/62.234.169.232(外) | consul server | 是 |
| node1 | 172.21.16.9(内)/62.234.206.29(外) | consul server | 否 |
| node2 | 172.21.16.14(内)/62.234.175.39(外) | consul server | 是 |

3.节点搭建
---
- 启动node0(172.21.16.16)机器上的Consul：
```
./consul agent -data-dir /tmp/node0 -node=node0 -bind=172.21.16.16 -datacenter=dc1 -ui -client=172.21.16.16 -server -bootstrap-expect 1
```
- 启动node1(172.21.16.9)机器上的Consul：
```
./consul agent -data-dir /tmp/node1 -node=node1 -bind=172.21.16.9 -datacenter=dc1 -ui
```
- 启动node2(172.21.16.14)机器上的Consul：
```
./consul agent -data-dir /tmp/node2 -node=node2 -bind=172.21.16.14 -datacenter=dc1 -ui -client=172.21.16.14
```
- 将node1(172.21.16.9)节点加入到node0(172.21.16.16)上（在node1机器上执行）：
```
./consul join 172.21.16.16 //前提，开通node0的8301端口(firewall-cmd --add-port=8301/tcp)
```
- 将node2(172.21.16.14)节点加入到node0(172.21.16.16)上（在node2机器上执行）：
```
./consul join -http-addr=http://172.21.16.14:8500 172.21.16.16
```
- 集群搭建完成，在node1(172.21.16.9)上查看当前节点：
```
./consul members -http-addr=http://172.21.16.16:8500
```
结果：
Node   Address            Status  Type    Build  Protocol  DC   Segment
node0  172.21.16.16:8301  alive   server  1.3.0  2         dc1  <all>
node1  172.21.16.9:8301   alive   client  1.3.0  2         dc1  <default>
node2  172.21.16.14:8301  alive   client  1.3.0  2         dc1  <default>