#ifndef TELEFONE_H
#define TELEFONE_H
#include<QString>
#include <itranformardados.h>
#include <QStringList>
namespace ejm{
class Telefone : public ITransformarDados
{
private:
    int ddi;
    int ddd;
    int numero;
public:
    Telefone():ddi(0),ddd(0),numero(0){}
    Telefone(int ddi,int ddd, int numero):ddi(ddi),ddd(ddd),numero(numero){}
    QString getTelefone()const;
    void setTelefone(int ddi, int ddd, int numero);
    QString desmaterializar()const;
    void materializar(QString str);
};
}
#endif // TELEFONE_H
