#include "telefone.h"
namespace ejm {

QString Telefone::getTelefone()const{
    QString saida;
    saida =  QString::number(ddi);
    saida += "(";
    saida += QString::number(ddd);
    saida += ")";
    saida += QString::number(numero);
    return saida;
}
void Telefone::setTelefone(int ddi, int ddd, int numero){
    this->ddi = ddi;
    this->ddd = ddd;
    this->numero = numero;
}
QString Telefone::desmaterializar()const{
    QString saida = "";
    saida += QString::number(ddi);
    saida += ";";
    saida += QString::number(ddd);
    saida += ";";
    saida += QString::number(numero);
    return saida;
}

void Telefone::materializar(QString str)
{
    QStringList dados = str.split(";");
    ddi = dados[0].toInt();
    ddd =dados[1].toInt();
    numero = dados[2].toInt();
}

}
