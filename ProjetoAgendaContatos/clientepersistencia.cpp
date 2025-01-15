#include "clientepersistencia.h"
namespace ejm{
ClientePersistencia::ClientePersistencia(QString nome):
    nomeDoArquivoNoDisco(nome)
{
}
void ClientePersistencia::incluir(Cliente &objeto) const{
    std::ofstream arquivoAgenda;
    arquivoAgenda.open(nomeDoArquivoNoDisco.toStdString().c_str(),
                        std::ios::out|std::ios::app);
    if(!arquivoAgenda.is_open()){
        throw QString("Arquivo de Agenda nao foi aberto - Metodo incluir");
    }
    arquivoAgenda<<objeto.desmaterializar().toStdString()+"\n";
    arquivoAgenda.close();
}

std::list<Cliente>*ClientePersistencia::listagem()const
{
    try {
       std::ifstream arquivoAgenda;
       arquivoAgenda.open((nomeDoArquivoNoDisco.toStdString().c_str()));

       if(!arquivoAgenda.is_open()){
           throw QString("Arquvio de Agenda nao foi aberto");

       }
       std::list<Cliente> *lista = new std::list<Cliente>();
       std::string linha;
       getline(arquivoAgenda,linha);
       while(!arquivoAgenda.eof()){
           ejm::Cliente objeto;
           QString str = QString::fromStdString(linha);
           objeto.materializar(str);
           lista->push_back(objeto);
           getline(arquivoAgenda,linha);
       }
       arquivoAgenda.close();
       return lista;
    } catch (QString &erro) {
        throw (erro);
    }
}

}


