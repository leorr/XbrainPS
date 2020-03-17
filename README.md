# XbrainPS
REST API do processo seletivo na Xbrain, utilizando Maven, H2 e RabbitMQ. 

```
          _____                    _____                    _____                _____          
         /\    \                  /\    \                  /\    \              /\    \         
        /::\    \                /::\    \                /::\    \            /::\    \        
       /::::\    \              /::::\    \              /::::\    \           \:::\    \       
      /::::::\    \            /::::::\    \            /::::::\    \           \:::\    \      
     /:::/\:::\    \          /:::/\:::\    \          /:::/\:::\    \           \:::\    \     
    /:::/__\:::\    \        /:::/__\:::\    \        /:::/__\:::\    \           \:::\    \    
   /::::\   \:::\    \      /::::\   \:::\    \       \:::\   \:::\    \          /::::\    \   
  /::::::\   \:::\    \    /::::::\   \:::\    \    ___\:::\   \:::\    \        /::::::\    \  
 /:::/\:::\   \:::\____\  /:::/\:::\   \:::\    \  /\   \:::\   \:::\    \      /:::/\:::\    \ 
/:::/  \:::\   \:::|    |/:::/__\:::\   \:::\____\/::\   \:::\   \:::\____\    /:::/  \:::\____\
\::/   |::::\  /:::|____|\:::\   \:::\   \::/    /\:::\   \:::\   \::/    /   /:::/    \::/    /
 \/____|:::::\/:::/    /  \:::\   \:::\   \/____/  \:::\   \:::\   \/____/   /:::/    / \/____/ 
       |:::::::::/    /    \:::\   \:::\    \       \:::\   \:::\    \      /:::/    /          
       |::|\::::/    /      \:::\   \:::\____\       \:::\   \:::\____\    /:::/    /           
       |::| \::/____/        \:::\   \::/    /        \:::\  /:::/    /    \::/    /            
       |::|  ~|               \:::\   \/____/          \:::\/:::/    /      \/____/             
       |::|   |                \:::\    \               \::::::/    /                           
       \::|   |                 \:::\____\               \::::/    /                            
        \:|   |                  \::/    /                \::/    /                             
         \|___|                   \/____/                  \/____/                       
```
feito:Gerar um pedidoID:
```
 _________________________
|         pedido          |
|.........................|
|-cod_cliente:String      |
|-cod_produtos:String     |
|-valor_total:Long        |
|-endereço_entrega:String |
\_________________________/
```
->banco funcional jpa integrado com h2,testes realizados com postman, falta implementações com rabbitmq:
falta:Gravar o pedido no banco e enviar o pedido para a uma fila de mensagem de entregas, usando **RabbitMQ**
falta:Criar um serviço para ler as entregas da fila e salvar na tabela Entrega (endereço de entrega e id do pedido)
