# Infbullet
Projeto InfBullet

Sistema de controle de notas escolares onde o aluno pode
cadastrar suas notas, escola, criar um perfil.
O usuário controla seu desempenho através do monitoramento das 
notas e o sistemas informa se esta dentro ou fora das metas 
pré-determinadas, tanto pela escola como pelo próprio aluno.
Organizando as notas de forma bimestra somado as medias de forma 
que se possa controla se o aluno está com um bom desempenho

O projeto e constituido de uma classe principal(Bulletin) que é a home
do aplicativo, um classe conecta o aluno com seus dados pessoais (Aluno)
através de uma classe que acessa a base de dados(AlunoDAO) tudo pela activity
que gera a interface com o usuário. A classe Agenda descreve os atributo para o 
cadstro de eventos no banco, a classe ProvaDAO implementa o cadastro de provas
com seus atributos setados na classe Prova.
A classe Disciplina Contem atibutos de cada disciplina e os metodos necessários
para o calculo da média das provas, uma disciplina possui varias provas. A
classe Bimestre contem Varias discilinas com duas ou tres provas cada, uma ou 
duas provas normais e uma recuperaçao ou prova final, sendo que o final dos quatro
bimestres é possível adcionar uma prova final.
A conexão com a base de dados é realizada por uma classe (BulletimDAO)
responsavel por criar o banco e as tabelas e cada classe possui uma DAO 
para gerenciar o acesso a sua repectiva tabela no banco
