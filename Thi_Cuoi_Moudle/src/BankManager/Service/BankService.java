package BankManager.Service;

import BankManager.Exception.NotFoundBankAccountException;
import BankManager.Models.Account;
import BankManager.Models.PaymentAccount;
import BankManager.Models.SavingAccount;
import BankManager.Utils.Validate;
import BankManager.Utils.Constant;
import BankManager.Utils.FileHelper;
import BankManager.Views.BankingView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankService {
    private List<Account> accountList = new ArrayList<>();

    FileHelper fileHelper = new FileHelper();

    public BankService() {
        accountList = mapToProducts();
    }

    public void create(Account account){

        int lastId = 0;
        if(accountList.size() > 0){
            lastId = accountList.get(accountList.size() - 1).getId();
        }

        account.setId(lastId + 1);
        accountList.add(account);
        fileHelper.write(Constant.path, Collections.singletonList(account), true);
    }

    public void delete(int id) throws NotFoundBankAccountException {
        Boolean flag = false;
        int index = 0;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getId()== id){
                index = i;
                flag = true;
            }
        }
            if (flag) {
                System.out.println("Bạn có muốn xóa hay không");
                System.out.println("1. Có");
                System.out.println("2. Không");
                int choice = Validate.getIntTwo();
                if (choice==1){
                    accountList.remove(index);
                    fileHelper.write(Constant.path,accountList,false);
                    return;
                }
                else {
                    BankingView.displayMenu();
                }
            } else {
                throw new NotFoundBankAccountException("ID " + id + " could not found");
            }

    }

    public List findAll(){
        return accountList;
    }

    public List searchByName(String name){
        List result = new ArrayList();

        for (int i = 0; i < accountList.size(); i++) {
            if(accountList.get(i).getName().contains(name)){
                result.add(accountList.get(i));
            }
        }

        return result;
    }

    private List mapToProducts(){
        List result = new ArrayList();

        List<String> lines = fileHelper.read(Constant.path);
        for (String line : lines){
            String[] tmp = line.split(",");
            int id = Integer.parseInt(tmp[0]);
            String code = tmp[1];
            String name = tmp[2];
            String openDate = tmp[3];

            if(tmp.length == 8){
                double amount = Double.parseDouble(tmp[4]);
                String dateSaving = tmp[5];
                double rate = Double.parseDouble(tmp[6]);
                int term = Integer.parseInt(tmp[7]);
                result.add(new SavingAccount(id, code,name,openDate,amount,dateSaving,rate,term));
            }
            else {
                int cardNumber = Integer.parseInt(tmp[4]) ;
                double cash = Double.parseDouble(tmp[5]);
                result.add(new PaymentAccount(id, code,name,openDate,cardNumber,cash));
            }
        }

        return result;
    }
}
