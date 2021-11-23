class User {
    constructor(socket, username, room) {
        this.socket = socket;
        this.username = username;
        this.room = room;

        this.colour = null
        this.chips = 0
        this.bet = 0
        this.hand = null  // replaced with Hand object
    }

    // methods that the user can use before they’re in a game room
    //////////////////////
    static createGame() {
        if (username !== null && !room) {
            socket.emit("create_game", socket.id, (gameRoom) => {
                    updateRoom(gameRoom);
            });
        }
    }

    static joinGame() {
        if (username !== null && !room) {
            socket.emit("join_game", socket.id, (gameRoom) => {
            if (gameRoom === false)  // no suitable games found
                this.createGame();
            else {
                updateRoom(gameRoom);
            }
            });
        }
    }

    // methods user can use in a game room
    ////////////////////
    static leaveGame() {
        if (username !== null && room) {
            socket.emit("leave_room", socket.id, () => {
                    leaveRoom();  // will turn room to null in the front end
            });
        }
    }

    static check() {
        if (username !== null && room) {
            // user checks
        }
    }

    static call() {
        if (username !== null && room) {
            // user calls
        }
    }



    static fold() {
        if (username !== null && room) {
            // user folds
        }
    }

    static raise(amount) {
        if (username !== null && room) {
            // user raises
        }
    }

}

exports.User = User;

class Deck {
    Card[] cardsdeck = new Card[52]
    constructor(cards, value) {
        this.cardsdeck = cardsdeck; //make a deck of all legal cards
    }

    static void deal() {
       for (/*num of players @ table*/) {
           for (int i = 0; i < 2; i++) {
               Random pick = new Random();
               int x = pick.nextInt(51);
               Hand.cards[0] = cardsdeck[x] // randomly deal 2 cards
                                            // for each player
           }
       }
       static void community() {
            for (int i = 0; i < 5; i++) {
                Random pick = new Random();
                int x = pick.nextInt(51);
               //pick 5 random community cards
            }
        }
    }
}