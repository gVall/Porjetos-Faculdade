#ifndef CLIENTEPERSISTENCIA_H
#define CLIENTEPERSISTENCIA_H
#include<cliente.h>
#include<crud.h>
#include<QString>
#include<fstream>

namespace ejm {
class ClientePersistencia:public CRUD
{
private:
    QString nomeDoArquivoNoDisco;
public:
    ClientePersistencia(QString nome);
    void incluir(Cliente &objeto) const;
    std::list<Cliente>* listagem()const;

};
}
#endif // CLIENTEPERSISTENCIA_H
