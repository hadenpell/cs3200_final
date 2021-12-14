# cs3200_final

#### Name of the project: Music Streaming Service

#### Name of the team(s):

* Haden Pelletier
* Steven Scangas
* Sebastien Fousse
* Sarah Casale

#### Brief description of the project:

A database that will manage the data relevant to a streaming service. The database will be implemented in SQL, and the user interface will be implemented in python.

#### Link to the latest data model as a single UML class diagram: https://github.com/hadenpell/db_design_final_project/blob/new/db_design_final_project_UML.pdf

#### Description of user data model:

The user data model keeps track of a user's id, first name, last name, username, password, email, and date of birth.

#### Description of the two domain object data models:

The two domain object data models are Song and Playlist. A song consists of an id, title, artist, genre, and release date. A playlist consists of an id, name, date of creation, and the id of the user who created the playlist.

#### Description of the user to domain object relationship:

A user can create multiple playlists, or no playlists.

#### Description of the domain object to domain object relationship:

A song can be included in many playlists, or in none. A playlist can consist of many songs, or none. The mapping table 'Added' is used to manage the many to many relationship between songs and playlists, as well as keeping track of the date a song is added to a playlist.

#### Description of the portable enumeration(s):

The enumeration is used to manage the available genres for songs. Currently included are the genres pop, rock, classical, country, and hip hop.

#### Description of the user interface requirements:

The user interface should be able to perform CRUD operations on users, songs, and playlists.
