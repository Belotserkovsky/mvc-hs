package by.academy.it.belotserkovsky.command.constants;

import by.academy.it.belotserkovsky.command.*;

/**
 * Constants to define commands
 * Created by K.Belotserkovsky
 */
public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    REGISTRATION{
        {
            this.command = new RegCommand();
        }
    },
    WORKERS_LIST{
        {
            this.command = new WorkersListCommand();
        }
    },
    BIDFORM{
        {
            this.command = new BidFormCommand();
        }
    },
    BID_SLIST{
        {
            this.command = new BidsListCommand();
        }
    },
    SHOWBIDFORM {
        {
        this.command = new ShowBidFormCommand();
        }
    },
    EDITCONTACT{
        {
          this.command = new EditContactCommand();
        }
    },
    SELECTWORKERS{
        {
            this.command = new SelectWorkersCommand();
        }
    },
    CREATEBID{
        {
            this.command = new CreateBidCommand();
        }
    },
    USERSLIST{
        {
            this.command = new UsersListCommand();
        }
    },
    ADMINPAGE{
        {
            this.command = new AdminPageCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
