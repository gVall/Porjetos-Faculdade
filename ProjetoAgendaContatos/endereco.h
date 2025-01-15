#ifndef ENDERECO_H
#define ENDERECO_H
#include<QString>
#include<itranformardados.h>
#include <QStringList>
namespace ejm {
class Endereco: public ITransformarDados
{
private:
    QString logradouro;
    QString complemento;
    QString cep;
public:
    Endereco();
    Endereco(QString logradouro, QString complemento, QString cep);
    QString getLogradouro()const{return logradouro;}
    QString getComplemento()const{return complemento;}
    QString getCep()const{return cep;}
    void setLogradour(QString logradouro){this->logradouro=logradouro;}
    void setComplemento(QString complemento){this->complemento = complemento;}
    void setCep(QString cep){this->cep = cep;}
    //reescrevendo
    QString desmaterializar()const;
    void materializar(QString str);

};
}
#endif // ENDERECO_H
