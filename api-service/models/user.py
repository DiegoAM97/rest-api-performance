from mongoengine import Document, StringField, IntField, BooleanField, EmailField, ListField, ObjectIdField

class User(Document):

    id = ObjectIdField(db_field="_id", primary_key=True)
    user_id = IntField(db_field="userId")
    name = StringField()
    surname = StringField()
    username = StringField()
    email = EmailField()
    is_admin = BooleanField(db_field="isAdmin")
    tech_skills = ListField(db_field="techSkills")

    meta = {'collection': 'users'}