#ifndef TELAPRINCIPAL_H
#define TELAPRINCIPAL_H

#include <QMainWindow>
#include<telefone.h>
#include<endereco.h>
#include<cliente.h>
#include<QMessageBox>
#include<clientepersistencia.h>
#include <QPixmap>
#include <telalistagem.h>

namespace Ui {
class TelaPrincipal;
}

class TelaPrincipal : public QMainWindow
{
    Q_OBJECT

public:
    explicit TelaPrincipal(QWidget *parent = nullptr);
    ~TelaPrincipal();

private slots:
    void on_pushButtonIncluir_clicked();

    void on_lineEditNum_textChanged(const QString &arg1);

    void on_pushButtonIncluirFoto_clicked();

    void on_pushButtonListagem_clicked();

private:
    void limparTela()const;
    Ui::TelaPrincipal *ui;
};

#endif // TELAPRINCIPAL_H
