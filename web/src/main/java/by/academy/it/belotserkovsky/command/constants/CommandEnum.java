package by.academy.it.belotserkovsky.command.constants;

import by.academy.it.belotserkovsky.command.*;

/**
 * constants to define commands
 * Created by Kostya on 09.04.2016.
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
    ADDWORKER{
        {
            this.command = new WorkerAddCommand();
        }
    },
    UPDATEWORKER{
        {
            this.command = new WorkerUpdateCommand();
        }
    },
    WORKERSLIST{
        {
            this.command = new WorkersListCommand();
        }
    },
    BRIGADESLIST {
        {
            this.command = new BrigadesListCommand();
        }
    },
    BIDFORM{
        {
            this.command = new BidFormCommand();
        }
    },
    BIDDISPLAY{
        {
            this.command = new BidDisplayCommand();
        }
    },
    BIDSLIST{
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
    }
    ;

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
