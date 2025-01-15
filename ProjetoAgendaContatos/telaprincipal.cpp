#include "telaprincipal.h"
#include "ui_telaprincipal.h"

#include <QFileDialog>

QString aux;

TelaPrincipal::TelaPrincipal(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::TelaPrincipal)
{
    ui->setupUi(this);
}

TelaPrincipal::~TelaPrincipal()
{
    delete ui;
}
void TelaPrincipal::limparTela()const{
    ui->lineEditNome->clear();
    ui->lineEditLogradouro->clear();
    ui->lineEditComplemento->clear();
    ui->lineEditCep->clear();
    ui->lineEditDDI->clear();
    ui->lineEditDDD->clear();
    ui->lineEditNum->clear();
    ui->lineEditEmail->clear();
    ui->lblFoto->clear();

}
void TelaPrincipal::on_pushButtonIncluir_clicked()
{
    try {
        QString nome = ui->lineEditNome->text();
        QString logradouro = ui->lineEditLogradouro->text();
        QString complemento = ui->lineEditComplemento->text();
        QString cep = ui->lineEditCep->text();
        QString email = ui->lineEditEmail->text();
        int ddi = ui->lineEditDDI->text().toInt();
        int ddd = ui->lineEditDDD->text().toInt();
        int numero = ui->lineEditNum->text().toInt();

        ejm::Telefone telefone(ddi,ddd,numero);
        ejm::Endereco endereco(logradouro,complemento,cep);
        ejm::Cliente cliente(nome,endereco,telefone,email,"");
        cliente.setFoto(aux);
        ejm::ClientePersistencia agenda("AgendaCliente.txt");
        agenda.incluir(cliente);
        limparTela();
    } catch (QString &erro) {
        QMessageBox::information(this,"ERRO",erro);
    }
}


void TelaPrincipal::on_pushButtonIncluirFoto_clicked()
{
    QString f = QFileDialog::getOpenFileName(this);
    QPixmap pix(f);
    ui->lblFoto->setPixmap(pix);
    aux = f;
}



void TelaPrincipal::on_pushButtonListagem_clicked()
{
    TelaListagem telaListar;
    telaListar.setModal(true);
    telaListar.exec();
}
