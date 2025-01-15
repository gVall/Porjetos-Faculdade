#include "endereco.h"
namespace ejm {
Endereco::Endereco():
    logradouro(""),
    complemento(""),
    cep("")
{
}
Endereco::Endereco(QString logradouro, QString complemento, QString cep):
    logradouro(logradouro),
    complemento(complemento),
    cep(cep)
{
}
QString Endereco::desmaterializar()const{
    QString saida = "";
    saida += this->logradouro;
    saida += ";";
    saida += this->complemento;
    saida += ";";
    saida += this->cep;
    return saida;
}
void Endereco::materializar(QString str)
{
    QStringList dados = str.split(";");
    logradouro = dados[0];
    complemento = dados[1];
    cep = dados[2];


}
}
