#include "cliente.h"

namespace ejm {

Cliente::Cliente():
    nomeCompleto(""),
    enderecoResidencial(),
    telefoneCompleto(),
    foto(""),
    email("")
{
}
Cliente::Cliente(QString nome, Endereco endereco, Telefone telefone,QString email, QString foto):
    nomeCompleto(nome),
    enderecoResidencial(endereco),
    telefoneCompleto(telefone),
    foto(foto),
    email(email)
{
}

QString Cliente::desmaterializar() const{
    QString saida = "";
    saida += this->nomeCompleto;
    saida +=";";
    saida += enderecoResidencial.desmaterializar();
    saida +=";";
    saida += telefoneCompleto.desmaterializar();
    saida +=";";
    saida += this->email;
    saida +=";";
    saida += this->foto;
    return saida;
}
void Cliente::materializar(QString str){
    QStringList dados = str.split("");
    nomeCompleto = dados[0];
    enderecoResidencial.setLogradour(dados[1]);
    enderecoResidencial.setComplemento(dados[2]);
    enderecoResidencial.setCep(dados[3]);
    telefoneCompleto.setTelefone(dados[4].toInt(),dados[5].toInt(),dados[6].toInt());
    foto = dados[7];

}

}
