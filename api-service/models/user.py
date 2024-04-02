from mongoengine import Document, StringField, IntField, BooleanField, EmailField, ListField

class User(Document):

    id = StringField(db_field="_id", primary_key=True)
    user_id = IntField(db_field="userId")
    name = StringField()
    surname = StringField()
    username = StringField()
    email = EmailField()
    is_admin = BooleanField(db_field="isAdmin")
    tech_skills = ListField(db_field="techSkills")

    meta = {'collection': 'users'}