// {
//     "id": 1,
//     "firstName": "Dias",
//     "middleName": null,
//     "lastName": "Ospanov 2",
//     "fullName": null,
//     "createdDate": null,
//     "roles": []
// }

async function startUsers() {
    console.log('startUsers')

    const users = await fetchUsersJson()
    console.log("Users: ", users)

    createUsersCards(users)
    console.log('Render users container')
}

function createUsersCards(users) {
    console.log("createUsersCards: ", users)
    const cards = document.getElementById('usersCards')

    for (let i = 0; i < users.length; i++) {
        const card = createUserCard(users[i])
        cards.append(card)
    }
}

function createUserCard(user) {
    console.log("createUserCard: ", user)

    const card = document.createElement('div')
    card.setAttribute('class', 'userCard')

    const hfn = document.createElement('h4')
    hfn.textContent = user['firstName']

    const hln = document.createElement('h4')
    hln.textContent = user.lastName

    card.append(hfn, hln)

    return card
}

async function fetchUsersJson() {
    const response = await fetch('http://localhost:8080/users');
    console.log("Response: ", response);

    const json = await response.json();
    console.log("Json: ", json);
    return json;
}

