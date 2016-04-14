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
    ADDBRIGADE{
        {
            this.command = new BrigadeAddCommand();
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
    BRIGADEADD{
        {
            this.command = new BrigadeAddCommand();
        }
    },
    BIDDISPLAY{
        {
            this.command = new BidDisplayCommand();
        }
    };

    ActionCommand command;

    public ActionCommand getCurrentCommand() {
        return command;
    }
}
