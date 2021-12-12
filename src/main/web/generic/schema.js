export const schema = {
    tables: [
        {
            name: 'users',
            label: 'User',
            labelPlural: 'Users',
            fields: [
                {name: 'id', label: 'ID', readonly: true},
                {name: 'username', label: 'Username'},
                {name: 'password', label: 'Password'},
                {name: 'firstName', label: 'First Name'},
                {name: 'lastName', label: 'Last Name'},
                {name: 'email', label: 'Email'},
                {name: 'dateOfBirth', label: 'DOB'}
            ],
            relations: [
                {name: 'playlists', label: 'Playlists', references: 'playlists'}
            ],
            list: {
                id: { show: false },
                username: { show: true },
                first_name: {show: true}
            }
        },
        {
            name: 'playlists',
            label: 'Playlist',
            labelPlural: 'Playlists',
            fields: [
                {name: 'id', label: 'PID', readonly: true},
                {name: 'name', label: 'Playlist Name'},
                {name: 'userId', label: 'User'},
                {name: 'createDate', label: 'Create Date'}
            ],
            relations: [
                {name: 'songs', label: 'Songs', references: 'songs'}
            ],
            list: {
                id: { show: false },
                name: { show: true }
            }
        },
        {
            name: 'songs',
            label: 'Song',
            labelPlural: 'Songs',
            fields: [
                {name: 'id', label: 'ID', readonly: true},
                {name: 'title', label: 'Title'},
                {name: 'artist', label: 'Artist'},
                {name: 'genre', label: 'Genre: Must be Rock,Hiphop,Pop,Classical,Country'},
                {name: 'releaseDate', label: 'Release Date'}

            ],
            relations: [
                {name: 'playlists', label: 'Playlists', references: 'playlists'}
            ],
            list: {
                id: { show: false },
                title: { show: true },
            }
        }

    ]
};