#ifndef CRUD_H
#define CRUD_H
#include<cliente.h>
namespace ejm{//inicio
class CRUD
{
public:
    virtual void incluir(Cliente &objeto) const = 0;
};
}//fim
#endif // CRUD_H
