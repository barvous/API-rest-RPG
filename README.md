(Versão 2: https://github.com/barvous/API-rest-RPG-v02 )

# API-rest-RPG
Um estudo de API REST, utilizando como base o RPG "Ordem Paranormal". Este projeto possui 2 classes simples "Habilidade" e "Personagem", e também possui classes
para exceções customizadas "BadRequestException", "NotFoundException" e "StandardError".

Os pacotes foram separados da seguinte forma:
>* controller
>>* É onde se encontra todos os controllers do projeto. Todos os endpoints estão contidos dentro desse pacote, separados por cada entidade.
>>* Este pacote também possui o "ExceptionController", que é onde estão as funções que retornam as exceções personalizadas para o usuário.

>* model
>>* No model, estão as classes onde construimos as entidades.Os atributos, construtores, getters e setters estão localizados dentro do model, separados por cada entidade.
>>* As entidades das Exceções personalizadas também estão neste pacote, dentro de outro pacote chamado "exception".

>* repository
>>* No repository, estão as interfaces que fazem a conexão com o JPA, estendendo da classe "JPARepository".

>* server
>>* É nesse pacoteque estão codificados todas as regras de negócio para que o sistema funcione com as suas particularidades. Este pacote é subdividido em Interfaces
>>* e Classes que farão a implementação destas interfaces. Dentro do pacote "server", as classes estão em um pacote chamado "Impl" que sugere que neste pacote só estejam as classes que implementão as interfaces.
