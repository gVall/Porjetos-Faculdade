#ifndef ITRANFORMARDADOS_H
#define ITRANFORMARDADOS_H
#include<QString>
namespace ejm {
class ITransformarDados{
    virtual QString desmaterializar() const = 0;
   virtual void materializar(QString str) = 0;
};
}


#endif // ITRANFORMARDADOS_H
