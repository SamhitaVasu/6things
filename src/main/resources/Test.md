# Controller Commands
* Bookmark
<ul>	<li> /bookmark - POST - save(final @RequestBody @Valid Bookmark bookmark) </li>
	<li> /bookmark - GET - getAll() </li>
	<li> /bookmark/{id} - GET - get(@PathVariable Long id) </li>
	<li> /bookmark/{id}/user - GET - getUser(@PathVariable Long id </li>
	<li> /bookmark/{id}/notebook - GET - getNotebook(@PathVariable Long id) </li>
	<li> /bookmark/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Comment
<ul><li> /comment - POST - save(final @RequestBody @Valid Comment comment) </li>
	<li> /comment - GET - getAll() </li>
	<li> /comment/{id} - GET - get(@PathVariable Long id) </li>
	<li> /comment/{id}/changeBody - PUT - changeBody(@RequestBody String body, @PathVariable Long id) </li>
	<li> /comment/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Folder
<ul><li> /folder - POST - save(final @RequestBody @Valid Folder folder) </li>
	<li> /folder - GET - getAll() </li>
	<li> /folder/{id} - GET - get(@PathVariable Long id) </li>
	<li> /folder/{id}/changeName - PUT - setName(@RequestBody String name, @PathVariable Long id) </li>
	<li> /folder/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Following
<ul><li> /following - POST - save(final @RequestBody @Valid Following following) </li>
	<li> /following - GET - getAll() </li>
	<li> /following/{id} - GET - get(@PathVariable Long id) </li>
	<li> /following/{id}/user - GET - getUser(@PathVariable Long id) </li>
	<li> /following/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Item
<ul><li> /item - POST - save(final @RequestBody @Valid Item item) </li>
	<li> /item/pull/{id} - POST - pull(@RequestBody Notebook notebook, @PathVariable Long id) </li>
	<li> /item - GET - getAll() </li>
	<li> /item/{id} - GET - get(@PathVariable Long id) </li>
	<li> /item/{id}/user - GET - getUser(@PathVariable Long id) </li>
	<li> /item/{id}/changeOrder - PUT - changeOrder(@RequestBody int pos, @PathVariable Long id) </li>
	<li> /item/{id}/changeBody - PUT - changeBody(@RequestBody String body, @RequestBody User user, @PathVariable Long id) </li>
	<li> /item/{id}/changeNumOfPulls - PUT - setNumOfPulls(@RequestBody int num, @PathVariable Long id) </li>
	<li> /item/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Notebook
<ul><li> /notebook - POST - save(final @RequestBody @Valid Notebook notebook)</li>
	<li> /notebook - GET - getAll() </li>
	<li> /notebook/{id} - GET - get(@PathVariable Long id) </li>
	<li> /notebook/{id}/collaborators - GET - getAccessList(@PathVariable Long id) </li>
	<li> /notebook/{id}/changePrivacy - PUT - setPrivacy(@RequestBody String privacy, @PathVariable Long id) </li>
	<li> /notebook/{id}/changeName - PUT - setName(@RequestBody String name, @PathVariable Long id) </li>
	<li> /notebook/{id}/changeDescription - PUT - setDescription(@RequestBody String description, @PathVariable Long id) </li>
	<li> /notebook/{id}/changeFolder - PUT - setFolder(@RequestBody Folder folder, @PathVariable Long id) </li>
	<li> /notebook/{id}/addCollaborators - PUT - addCollaborator(@RequestBody User user, @PathVariable Long id) </li>
	<li> /notebook/{id}/removeCollaborators - PUT - removeCollaborator(@RequestBody User user, @PathVariable Long id) </li>
	<li> /notebook/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Tag
<ul><li> /tag - POST - save(final @RequestBody @Valid Tag tag) </li>
	<li> /tag - GET - getAll() </li>
	<li> /tag/{id} - GET - get(@PathVariable Long id) </li>
	<li> /tag/{id} - DELETE - delete(@PathVariable Long id) </li></ul>
* Tenant
<ul><li> /tenant - POST - save(final @RequestBody @Valid Tenant tenant) </li>
	<li> /tenant - GET - getAll() </li>
	<li> /tenant/{id} - GET - get(@PathVariable Long id) </li>
	<li> /tenant/{id}/status - GET - getStatus(@PathVariable Long id) </li>
	<li> /tenant/{id} - PUT - deactivate(@PathVariable Long id) </li></ul>
* User
<ul><li> /user - POST - save(final @RequestBody @Valid User user) </li>
	<li> /user - GET - getAll() </li>
	<li> /user/{id} - GET - get(@PathVariable Long id) </li>
	<li> /user/email/{email} - GET - getByEmail(@PathVariable String email) </li>
	<li> /user/{id}/followings - GET - getFollowings(@PathVariable Long id) </li>
	<li> /user/{id}/bookmarks - GET - getBookmarks(@PathVariable Long id) </li>
	<li> /user/{id}/changeTenant - PUT - setTenant(@RequestBody Tenant tenant, @PathVariable Long id) </li>
	<li> /user/{id}/changeName - PUT - setName(@RequestBody String name, @PathVariable Long id) </li></ul>

# Entities 

* Bookmark
<ul>	<li> bookmark_id, user, notebook </li>
	<li> Bookmark(User user, Notebook notebook) </li>
	<li> getBookmarkNotebook() </li>
	<li> getUser() </li>
	<li> getId() </li></ul>
* Comment
	<ul>	<li> comment_id, body, item, user </li> 
	<li> Comment(User user, String body, Item item) </li>
	<li> getItem() </li>
	<li> getId() </li>
	<li> getBody() </li>
	<li> setBody(String body) </li>
	<li> getUser() </li> </ul>
* Folder
	<ul>	<li> folder_id, name, notebooks, user </li>
	<li> Folder(String name, User user) </li>
	<li> getNotebooks() </li>
	<li> getUser() </li>
	<li> getId() </li>
	<li> getName() </li>
	<li> setName(String name) </li></ul>
* Following
	<ul>	<li> following_id, user, followingNotebook </li>
	<li> Following(User user, Notebook notebook) </li>
	<li> getFollowing() </li>
	<li> getUser() </li>
	<li> getId() </li></ul>
* Item
	<ul><li> item_id, body, numOfPulls, itemType, order, user, tags, comments, notebook </li>
	<li> Item(int order, String body, String itemType, Notebook notebook, User user) </li>
	<li> getTags() </li>
	<li> getComments() </li>
	<li> getNotebook() </li>
	<li> setNotebook(Notebook notebook) </li>
	<li> getUser() </li>
	<li> getId() </li>
	<li> getItemType() </li>
	<li> getOrder() </li>
	<li> setOrder(int order) </li>
	<li> getBody() </li>
	<li> setBody(String body) </li>
	<li> getNumOfPulls() </li>
	<li> setNumOfPulls(int num) </li></ul>
* Notebook
	<ul><li> notebook_id, name, description, privacy, collaborators, items, folder, bookmarks, followers, admn </li>
	<li> Notebook(String name, String description, User admn) **OR** Notebook(String name, String description, Folder folder) **OR** Notebook(Long id, String name, String description, String privacy, User admn) **OR** Notebook(Long id, String name, String description, String privacy, Folder folder) </li>
	<li> getItems() </li>
	<li> getFolder() </li>
	<li> setFolder(Folder folder) </li>
	<li> getId() </li>
	<li> getName() </li>
	<li> setName(String name) </li>
	<li> getDescription() </li>
	<li> setDescription(String description) </li>
	<li> getPrivacy() </li>
	<li> setPrivacy(String privacy) </li>
	<li> getCollaborators() </li>
	<li> addCollaborators(User user) </li>
	<li> removeCollaborators(User user) </li></ul>
* Tag
	<ul><li> tag_id, tag, item </li> 
	<li> Tag(String tag, Item item) </li>
	<li> getItem() </li>
	<li> getId() </li>
	<li> getTag() </li></ul>
* Tenant
	<ul><li> tenant_id, active, users </li> 
	<li> Tenant() </li> 
	<li> getUsers() </li> 
	<li> getId() </li> 
	<li> getStatus() </li> 
	<li> deactivate() </li></ul>
* User
	<ul><li> user_id, email, name, notebooks, folders, bookmarks, followings, items, comments, tenant </li> 
	<li> User(String email) **OR** User(String email, Tenant tenant) </li> 
	<li> getNotebooks() </li> 
	<li> getFolders() </li> 
	<li> getTenant() </li> 
	<li> setTenant(Tenant tenant) </li> 
	<li> getFollowings() </li>
	<li> getBookmarks() </li> 
	<li> getComments() </li> 
	<li> getId() </li> 
	<li> getEmail() </li> 
	<li> getName() </li> 
	<li> setName(String name) </li></ul>