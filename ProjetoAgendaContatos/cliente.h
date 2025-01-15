#ifndef CLIENTE_H
#define CLIENTE_H
#include<QString>
#include<endereco.h>
#include<itranformardados.h>
#include <telefone.h>
#include <QStringList>
namespace ejm{
class Cliente: public ITransformarDados
{
private:
    QString nomeCompleto;
    Endereco enderecoResidencial;
    Telefone telefoneCompleto;
    QString foto;
    QString email;
public:
    Cliente();
    Cliente(QString nome, Endereco endereco, Telefone telefone, QString email, QString foto);
    QString getNomeCompleto()const{return nomeCompleto; }
    void setNomeCompleto(QString nome){this->nomeCompleto=nome;}
    QString getFoto()const{return foto; }
    void setFoto(QString foto){this->foto = foto;}
    QString getEmail()const{return email;}
    void setEmail(QString email){this->email = email;}
    Telefone getTelefone()const{return this->telefoneCompleto;}
    void setTelfoneCompleto(Telefone objTel){ this->telefoneCompleto = objTel;}
    Endereco getEnderecoResidencial()const{return this->enderecoResidencial;}
    void setEnderecoResidencial(Endereco objEndereco)
                            {this->enderecoResidencial=objEndereco;}
    //reescrever
    QString desmaterializar() const;
    void materializar(QString str);
};
}
#endif // CLIENTE_H
